public class CoinChange {

    enum Coin {
        QUARTER(25),
        DIME(10),
        NICKEL(5),
        PENNY(1);

        private final int cents;
        Coin(int cents) { this.cents = cents; }
        public int getCents() { return cents; }
    }

    // Greedy algorithm — for these denominations, greedy is optimal
    static void fewestCoins(int amountInCents) {
        if (amountInCents < 0) throw new IllegalArgumentException("Negative amount");

        System.out.println("Amount: " + amountInCents + " cents");
        int remaining = amountInCents;

        // Coin.values() returns constants in declaration order (largest first here)
        for (Coin coin : Coin.values()) {
            int count = remaining / coin.getCents();
            if (count > 0) {
                System.out.printf("  %-8s x%d%n", coin, count);
                remaining -= count * coin.getCents();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        fewestCoins(87);   // 3 quarters, 1 dime, 0 nickel, 2 pennies
        fewestCoins(41);   // 1 quarter, 1 dime, 1 nickel, 1 penny
        fewestCoins(6);    // 1 nickel, 1 penny
    }
}