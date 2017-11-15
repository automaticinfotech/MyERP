package com.aits.myerp.dto;


public class MenuMasterDto {

	private Integer MenuId;
	private String MenuName;
	private Boolean isActive;
	
	public Integer getMenuId() {
		return MenuId;
	}
	public void setMenuId(Integer menuId) {
		MenuId = menuId;
	}
	public String getMenuName() {
		return MenuName;
	}
	public void setMenuName(String menuName) {
		MenuName = menuName;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((MenuId == null) ? 0 : MenuId.hashCode());
		result = prime * result + ((MenuName == null) ? 0 : MenuName.hashCode());
		result = prime * result + ((isActive == null) ? 0 : isActive.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuMasterDto other = (MenuMasterDto) obj;
		if (MenuId == null) {
			if (other.MenuId != null)
				return false;
		} else if (!MenuId.equals(other.MenuId))
			return false;
		if (MenuName == null) {
			if (other.MenuName != null)
				return false;
		} else if (!MenuName.equals(other.MenuName))
			return false;
		if (isActive == null) {
			if (other.isActive != null)
				return false;
		} else if (!isActive.equals(other.isActive))
			return false;
		return true;
	}
}
