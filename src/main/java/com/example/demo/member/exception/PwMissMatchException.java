package com.example.demo.member.exception;

@SuppressWarnings("serial")
public class PwMissMatchException extends RuntimeException {
	public PwMissMatchException(String msg){ super(msg); }
}