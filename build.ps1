param(
  [string]$TomcatHome = $env:TOMCAT_HOME,
  [string]$MySqlConnector = $env:MYSQL_CONNECTOR_JAR
)
$ErrorActionPreference = 'Stop'
if (-not $TomcatHome -or -not (Test-Path (Join-Path $TomcatHome 'lib/servlet-api.jar'))) { throw 'Set TOMCAT_HOME to an Apache Tomcat 10.1 installation.' }
if (-not $MySqlConnector -or -not (Test-Path $MySqlConnector)) { throw 'Set MYSQL_CONNECTOR_JAR to the MySQL Connector/J jar.' }
$root = $PSScriptRoot
$build = Join-Path $root 'build'
$stage = Join-Path $build 'stage'
$classes = Join-Path $stage 'WEB-INF/classes'
if (Test-Path $stage) { Remove-Item -LiteralPath $stage -Recurse -Force }
New-Item -ItemType Directory -Force -Path $classes,(Join-Path $stage 'WEB-INF/lib') | Out-Null
Copy-Item -Path (Join-Path $root 'src/main/webapp/*') -Destination $stage -Recurse -Force
$sources = Get-ChildItem -Path (Join-Path $root 'src/main/java') -Filter '*.java' -Recurse | ForEach-Object { $_.FullName }
$classpath = Join-Path $TomcatHome 'lib/servlet-api.jar'
& javac -encoding UTF-8 -cp $classpath -d $classes $sources
if ($LASTEXITCODE -ne 0) { throw 'Java compilation failed.' }
Copy-Item -LiteralPath $MySqlConnector -Destination (Join-Path $stage 'WEB-INF/lib/mysql-connector-j.jar')
$jar = Join-Path (Split-Path (Get-Command javac).Source) 'jar.exe'
New-Item -ItemType Directory -Force -Path $build | Out-Null
& $jar --create --file (Join-Path $build 'etpms.war') -C $stage .
if ($LASTEXITCODE -ne 0) { throw 'WAR packaging failed.' }
Write-Output "Created $(Join-Path $build 'etpms.war')"
