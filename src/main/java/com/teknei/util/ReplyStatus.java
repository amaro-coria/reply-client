/**
 * Teknei 2016
 */
package com.teknei.util;

import java.time.LocalDate;

/**
 * Singleton class for holding access to replication on bus
 * @author Jorge Amaro
 * @version 1.0
 * @since 1.0
 *
 */
public class ReplyStatus {

	private ReplyStatus(){
		
	}

	private static ReplyStatus instance = new ReplyStatus();
	
	public static ReplyStatus getInstance(){
		return instance;
	}
	
	private boolean free = true;
	private LocalDate time;
	private String detail;
	private int errorCounter;
	private boolean lastStatusWasError = false;
	
	/**
	 * Increments in 1 the error counter
	 */
	public void addError(){
		errorCounter++;
	}
	
	/**
	 * Reset to zero the error counter
	 */
	public void resetErrorCounter(){
		errorCounter = 0;
	}

	/**
	 * @return the free
	 */
	public boolean isFree() {
		return free;
	}
	/**
	 * @param free the free to set
	 */
	public void setFree(boolean free) {
		this.free = free;
	}
	/**
	 * @return the time
	 */
	public LocalDate getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(LocalDate time) {
		this.time = time;
	}
	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	/**
	 * @return the errorCounter
	 */
	public int getErrorCounter() {
		return errorCounter;
	}
	/**
	 * @param errorCounter the errorCounter to set
	 */
	public void setErrorCounter(int errorCounter) {
		this.errorCounter = errorCounter;
	}

	/**
	 * @return the lastStatusWasError
	 */
	public boolean isLastStatusWasError() {
		return lastStatusWasError;
	}

	/**
	 * @param lastStatusWasError the lastStatusWasError to set
	 */
	public void setLastStatusWasError(boolean lastStatusWasError) {
		this.lastStatusWasError = lastStatusWasError;
	}
	
}
