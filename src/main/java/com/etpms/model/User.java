package com.etpms.model;
public class User { public long id; public String username,role,firstName,lastName,email; public String name(){return ((firstName==null?"":firstName)+" "+(lastName==null?"":lastName)).trim();} }
