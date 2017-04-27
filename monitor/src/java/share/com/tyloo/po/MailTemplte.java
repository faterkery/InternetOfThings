package com.tyloo.po;

public class MailTemplte extends com.tyloo.fw.orm.IdPersistent implements
        java.io.Serializable
{
    /**
     * email 模板
     */
private static final long serialVersionUID = -6498651579225469040L;
    private String numbers;
    private String subject;
    private String content;
	public String getNumbers() {
		return numbers;
	}
	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}