package com.jcg.servlet;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
	private final AtomicInteger activeSessions;

	public SessionListener() {
		super();

		activeSessions = new AtomicInteger();
	}

	public int getTotalActiveSession() {
		return activeSessions.get();
	}

	public void sessionCreated(final HttpSessionEvent event) {
		activeSessions.incrementAndGet();
		System.out.println("sessionCreated::activeSessions: " + activeSessions);
	}

	public void sessionDestroyed(final HttpSessionEvent event) {
		activeSessions.decrementAndGet();
		System.out.println("sessionDestroyed::activeSessions: " + activeSessions);
	}
}
