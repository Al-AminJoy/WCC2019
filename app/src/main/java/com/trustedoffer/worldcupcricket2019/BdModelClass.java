package com.trustedoffer.worldcupcricket2019;

public class BdModelClass {
    private String image;
    private String name,role;

    public BdModelClass(String image, String name, String role) {
        this.image = image;
        this.name = name;
        this.role = role;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
