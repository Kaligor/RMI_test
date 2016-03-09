package com.dragonfire;

import javax.swing.DefaultListModel;

public class cardLogics
{

    DefaultListModel<Card> myHand = new DefaultListModel<>();

    public Card addCard(Card card)
    {
        
        myHand.addElement(card);
        return card;
    }

    public void discardCard(int index)
    {
        myHand.remove(index);
    }
}
