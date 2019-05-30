package com.acquisio.app.domain;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import java.util.*;
import java.io.*;
import java.security.*;




@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    private int salary;
	
	/*
	@Column(name = "email_md5_hash")
	private String emailMd5Hash;
	*/
	
	@Column(name = "gravatar_image_url")
	private String gravatarImageURL;
	
	

    Employee() {
        // JPA only
    }

    public Employee(String firstName, String lastName, String email, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.email = email;
		
		//this.emailMd5Hash = md5Hex(email.toLowerCase());
		this.gravatarImageURL = "https://www.gravatar.com/avatar/" + md5Hex(email.toLowerCase());
		
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
	
	/*
	public String getEmailMd5Hash() {
        return emailMd5Hash;
    }

    public void setEmailMd5Hash(String emailMd5Hash) {
        this.emailMd5Hash = emailMd5Hash;
    }
	*/
	
	public String getGravatarImageURL() {
        return gravatarImageURL;
    }

    public void setGravatarImageURL(String gravatarImageURL) {
        this.gravatarImageURL = gravatarImageURL;
    }
	
	
	
	//https://en.gravatar.com/site/implement/images/java/
	public static String hex(byte[] array) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; ++i) {
		sb.append(Integer.toHexString((array[i]
		  & 0xFF) | 0x100).substring(1,3));        
		}
		return sb.toString();
	}
	
	public static String md5Hex (String message) {
		try {
		MessageDigest md = 
		  MessageDigest.getInstance("MD5");
		return hex (md.digest(message.getBytes("CP1252")));
		} catch (NoSuchAlgorithmException e) {
		} catch (UnsupportedEncodingException e) {
		}
		return null;
	}
	
}
