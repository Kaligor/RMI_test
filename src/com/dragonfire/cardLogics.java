package com.dragonfire;

import javax.swing.DefaultListModel;

public class cardLogics
{

    DefaultListModel<Card> myHand = new DefaultListModel<>();

    public void addCard(Card card)
    {
        myHand.addElement(card);
    }

    public void discardCard(int index)
    {
        myHand.remove(index);
    }
}
