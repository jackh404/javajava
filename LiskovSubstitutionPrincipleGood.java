//Liskov Substitution Principle
abstract class Computer {
	public int amount_of_ram = 4;
	public int os_version = 1;
	public abstract void updateOS();
}

class Phone extends Computer {
	public void updateOS() {
		this.os_version += 1;
	}
}

class ComputerUpgrader {
	public void upgradeRAM(HardwareUpgradable d) { //2
		d.addRam(16);	
	}

	public void upgradeOS(Computer d) { //3
		d.updateOS();
	}
}
class DesktopComputer extends Computer implements HardwareUpgradable { //4
	public void addRam(int gb) { //5
		this.amount_of_ram += gb;
	}

	public void updateOS() { //6
		this.os_version += 1;
	}
}

interface HardwareUpgradable {
	void addRam(int gb);
}

class LiskovSubstitutionPrincipleGood {
    public static void main (String[] args) {
        ComputerUpgrader upgrader = new ComputerUpgrader();
        DesktopComputer desktopPC = new DesktopComputer();
        Phone phone = new Phone();

        System.out.println("Before the OS update and RAM upgrade: ");
        printInfo(desktopPC, phone);

        upgrader.upgradeOS(desktopPC);
        upgrader.upgradeRAM(desktopPC);
        upgrader.upgradeOS(phone);
        // Following is not applicable
        // upgrader.upgradeRAM(phone);

        System.out.println("After the OS update and RAM upgrade: ");
        printInfo(desktopPC, phone);

    }

    static void printInfo(Computer desktopPC, Computer phone) {
        System.out.println("Desktop Computer has OS version: " + desktopPC.os_version + ", and amount of RAM: " +
                desktopPC.amount_of_ram + " GB.");
        System.out.println("Phone has OS version: " + phone.os_version + ", and amount of RAM: " + phone.amount_of_ram +
                " GB.");
    }
}
