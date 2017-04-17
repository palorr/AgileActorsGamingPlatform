package com.agile.resources;

/**
 * resource containing the information we want to show
 * 
 * @author NikosMas
 *
 */
public class GameResource {

	private int id;
	private int buyCredits;
	private int winCredits;
	private String name;
	private String description;
	private String avatar;

	public GameResource() {
		super();
	}

	/**
	 * @param id
	 * @param buyCredits
	 * @param winCredits
	 * @param name
	 * @param description
	 * @param avatar
	 */
	public GameResource(int id, int buyCredits, int winCredits, String name, String description, String avatar) {
		super();
		this.id = id;
		this.buyCredits = buyCredits;
		this.winCredits = winCredits;
		this.name = name;
		this.description = description;
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBuyCredits() {
		return buyCredits;
	}

	public void setBuyCredits(int buyCredits) {
		this.buyCredits = buyCredits;
	}

	public int getWinCredits() {
		return winCredits;
	}

	public void setWinCredits(int winCredits) {
		this.winCredits = winCredits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}
