public final class ResultsPrinter {
	private ResultsPrinter(){
	}

	/*
	 * This is what One result should look like when printed
	 ============================================================
	 | Decimal         | Binary
	 ------+-----------------+----------------------------------------
	 IP	   | 192.168.1.110   | 11000000.10101000.00000001.01101110
	 Mask  | 255.255.255.128 | 11111111.11111111.11111111.10000000
	 Net   | 192.168.1.0     | 11000000.10101000.00000001.00000000
	 Bcast | 192.168.1.127   | 11000000.10101000.00000001.01111111
	 ============================================================

*/
	public static void displaySingleResult(ResultsData ip) {
		// Decimal table
		System.out.println("================================================");
		System.out.printf("%-8s | %-19s%n", "", "IP");
		System.out.println("---------+---------------------");
		System.out.printf("%-8s | %-19s%n", "IP", ip.getValidatedIp());
		System.out.printf("%-8s | %-19s%n", "Mask", ip.getValidatedMask());
		System.out.printf("%-8s | %-19s%n", "Net", ip.getNetworkIp());
		System.out.printf("%-8s | %-19s%n", "Bcast", ip.getBroadcastIp());
		System.out.println("================================================");

		// Binary representation
		String[] labels = {"Addr   ", "Mask   ", "Net    ", "Bcast  "};
		String[] binaryData = {ip.getBinaryIp(), ip.getBinaryMask(), ip.getBinaryNet(), ip.getBinaryBroad()};

		for (int i = 0; i < labels.length; i++) {
			System.out.printf("%-7s : %-35s%n", labels[i], binaryData[i]);
		}
	}

	public static void displayIpPairResult(IpPairResult pair) {
		ResultsData ip1 = pair.getFirst();
		ResultsData ip2 = pair.getSecond();

		// Decimal table header
		System.out.println("================================================");
		System.out.printf("%-8s | %-19s | %-19s%n", "", "IP A", "IP B");
		System.out.println("---------+---------------------+----------------");

		// Decimal data
		System.out.printf("%-8s | %-19s | %-19s%n", "IP", ip1.getValidatedIp(), ip2.getValidatedIp());
		System.out.printf("%-8s | %-19s | %-19s%n", "Mask", ip1.getValidatedMask(), ip2.getValidatedMask());
		System.out.printf("%-8s | %-19s | %-19s%n", "Net", ip1.getNetworkIp(), ip2.getNetworkIp());
		System.out.printf("%-8s | %-19s | %-19s%n", "Bcast", ip1.getBroadcastIp(), ip2.getBroadcastIp());
		System.out.println("================================================");

		// Binary data
		String[] labels = {"Addr   ", "Mask   ", "Net    ", "Bcast  "};
		String[] binary1 = {ip1.getBinaryIp(), ip1.getBinaryMask(), ip1.getBinaryNet(), ip1.getBinaryBroad()};
		String[] binary2 = {ip2.getBinaryIp(), ip2.getBinaryMask(), ip2.getBinaryNet(), ip2.getBinaryBroad()};

		for (int i = 0; i < labels.length; i++) {
			System.out.printf("%-7s A | %-35s %n%8sB | %-35s%n", labels[i], binary1[i]," ", binary2[i]);
		}

		// Communication info
		System.out.println();
		System.out.println("Reachability:");
		if (pair.canFirstReachSecond() && pair.canSecondReachFirst()) {
			System.out.println("Both IPs can communicate with each other.");
		} else if (pair.canFirstReachSecond()) {
			System.out.println("IP A can reach IP B, but IP B cannot reach IP A.");
		} else if (pair.canSecondReachFirst()) {
			System.out.println("IP B can reach IP A, but IP A cannot reach IP B.");
		} else {
			System.out.println("Neither IP can reach the other.");
		}
	}

}
