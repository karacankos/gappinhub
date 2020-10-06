package com.swt.gapp1.gappdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class GappDataBasic extends GappDataAbstract {
	
    public GappDataBasic(long id, String string, boolean completed) {
        this.id = id;
        this.text = string;
        this.completed = completed;
    }

    public GappDataBasic(String string, boolean completed) {
        this.text = string;
        this.completed = completed;
	}

    public GappDataBasic() {
        this.text = "text";
        this.completed = true;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	//
	@Id
    @GeneratedValue
	private long id;
    
    private String text;
	private boolean completed;


}
