import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class ArchTome {
	public static void main(String[] args) {
		if (args.length == 2) {
			System.out.println("Chance to get tome: "+tomeMath(Double.parseDouble(args[0]), Double.parseDouble(args[1]))+"%");
		} else if (args.length == 1 && args[0].contains("1")) {
			getUserInput();
		} else {
			System.out.println("ArchTome <archLevel> <spotLevel>");
		}
	}

	private static void getUserInput() {
		try (Scanner in = new Scanner(System.in)) {
			double archLevel, spotLevel;

			System.out.print("Arch Level: ");
			archLevel = in.nextDouble();

			System.out.print("Spot Level: ");
			spotLevel = in.nextDouble();

			System.out.println("Chance to get tome: "+tomeMath(archLevel, spotLevel)+"%");
		} catch (Exception e) {
			System.out.println("Answers must be a number.");
		}
	}

	private static BigDecimal tomeMath(double archLevel, double spotLevel) {
		BigDecimal tomeChance = new BigDecimal(((archLevel + spotLevel) / 250000));
		tomeChance = tomeChance.setScale(6, RoundingMode.CEILING);

		return tomeChance;
	}
}