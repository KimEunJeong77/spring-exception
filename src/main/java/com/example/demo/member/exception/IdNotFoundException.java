package com.example.demo.member.exception;

@SuppressWarnings("serial")
public class IdNotFoundException extends RuntimeException {
	public IdNotFoundException(String msg){ super(msg); }
}
