package Interviews.aakashedu;

public class RecycleCartridges {

    public static int maxPerksItems(int cartridges, int dollars, int recycleReward, int perksCost) {
        if((dollars <= 0 && cartridges <= 0) || perksCost <=0) {
            return 0;
        }

        int canBuy = dollars/perksCost;
        int totalBuy = 0;
        if(cartridges <= canBuy){
            return cartridges;
        }
        else{
            totalBuy = canBuy;
        }

        while(canBuy < cartridges){
            totalBuy = canBuy;
            cartridges--;
            dollars += recycleReward;
            canBuy = dollars/perksCost;
        }
        if (cartridges <= canBuy) {
            return cartridges;
        }
        return totalBuy;
    }

    public static void main(String[] args) {
        System.out.println(maxPerksItems(4,8,3,4));
        System.out.println(maxPerksItems(10, 10, 2, 2));
        System.out.println(maxPerksItems(0, 10, 2, 2));
        System.out.println(maxPerksItems(1, 10, 2, 2));
        System.out.println(maxPerksItems(5, 10, 2, 20));
        System.out.println(maxPerksItems(5, 12, 2, 20));
        System.out.println(maxPerksItems(8, 12, 2, 2));
        System.out.println(maxPerksItems(8, 12, 14, 2));
        System.out.println(maxPerksItems(737, 677, 893, 87));
    }
}
