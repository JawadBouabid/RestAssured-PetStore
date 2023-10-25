package payload;

import java.util.List;



import groovy.lang.Category;

public class Pet {
	int id;
	PetCategory category;
	String name;
	List<String> urls;
	List<PetTag> tags;
	String status = "Available";
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PetCategory getCategory() {
		return category;
	}
	public void setCategory(PetCategory category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getUrls() {
		return urls;
	}
	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
	public List<PetTag> getTags() {
		return tags;
	}
	public void setTags(List<PetTag> tags) {
		this.tags = tags;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
