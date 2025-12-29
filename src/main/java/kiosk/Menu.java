package kiosk;

public class Menu {
    public enum Burger {
        WHOPPER("와퍼", 6900),
        CUBE_STEAK_WOPPER("큐브 스테이크 와퍼", 8900),
        QUATRO_CHEESE_WHOPPER("콰트로 치즈 와퍼", 7900),
        MONSTER_WHOPPER("몬스터 와퍼", 9300),
        SHIRIMP_WHOPPER("통새우 와퍼", 7900),
        BLACK_BBQ_WHOPPER("블랙바베큐 와퍼", 9300);

        private final String burgerName;
        private final int burgerPrice;

        Burger(String burgerName, int burgerPrice) {
            this.burgerName = burgerName;
            this.burgerPrice = burgerPrice;
        }

        public String getName() { return burgerName; }
        public int getPrice() { return burgerPrice; }
    }

    public enum SideDish {
        NUGGET_KING("너겟킹", 2500),
        HASHBROWN("해쉬 브라운", 1800),
        CHEESE_STICK ("치즈스틱", 1200),
        ONION_RING("어니언링", 2400),
        BASAK_KING("바삭킹", 3000),
        FRENCH_FRIES("감자튀김", 2000);

        private final String sideName;
        private final int sidePrice;

        SideDish(String sideName, int sidePrice) {
            this.sideName = sideName;
            this.sidePrice = sidePrice;
        }

        public String getName() { return sideName; }
        public int getPrice() { return sidePrice; }
    }

    public enum Drink {
        COCACOLA("코카콜라", 2500),
        COCACOLA_ZERO("코카콜라 제로", 2000),
        PEPSI ("팹시", 2000),
        PEPSI_ZERO("팹시 제로", 2000),
        SPRITE("스프라이트", 2000),
        SPRITE_ZERO("스프라이트 제로", 2000);

        private final String drinkName;
        private final int drinkPrice;

        Drink(String drinkName, int drinkPrice) {
            this.drinkName = drinkName;
            this.drinkPrice = drinkPrice;
        }

        public String getName() { return drinkName; }
        public int getPrice() { return drinkPrice; }
    }
}
