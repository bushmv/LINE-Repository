package fluent;

public class Hero {

    private final int strength;
    private final int agility;
    private final int stamina;

    private Hero(int strength, int agility, int stamina) {
        this.strength = strength;
        this.agility = agility;
        this.stamina = stamina;
    }

    public static class HeroBuilder {

        private int strength;
        private int agility;
        private int stamina;

        public HeroBuilder strength(int strength) {
            this.strength = strength;
            return this;
        }

        public HeroBuilder agility(int agility) {
            this.agility = agility;
            return this;
        }

        public HeroBuilder stamina(int stamina) {
            this.stamina = stamina;
            return this;
        }

        public Hero create() {
            return new Hero(strength, agility, stamina);
        }

    }




}
