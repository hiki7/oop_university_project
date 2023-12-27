package Testers;

import Information.Data;
import Users.*;

public class Adm {

	public static void main(String[] args) {
		Admin admin = new Admin("a","a", UserRole.ADMIN , "a", "a", Gender.MALE, 1, false, false, 2000000);
		Data.getInstance().getUsers().add(admin);
		Data.getInstance().saveToFile("a.ser");

	}

}
