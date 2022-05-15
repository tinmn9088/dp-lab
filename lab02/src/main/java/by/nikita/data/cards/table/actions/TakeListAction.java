package by.nikita.data.cards.table.actions;

import by.nikita.data.cards.Card;

import java.util.List;

public interface TakeListAction extends TakeAction {

    @Override
    List<Card> getTaken();
}
