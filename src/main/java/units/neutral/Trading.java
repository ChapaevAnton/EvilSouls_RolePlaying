package units.neutral;

import units.fight.FightUnit;

public interface Trading {

    void trade(FightUnit player, Dealer.Goods selectedItem);

}
