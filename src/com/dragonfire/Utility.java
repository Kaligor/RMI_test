package com.dragonfire;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class Utility
{
    
    String fileLocation = "/resources/";
    
    public ListCellRenderer newCellRenderer()
    {
//        System.out.println(getClass().getResource(fileLocation + "test.jpg"));
        return new cardCellRenderer();
    }
    
    public class cardCellRenderer extends JLabel implements ListCellRenderer
    {
        
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
        {
            
            Card card = (Card) value;
            
//            System.out.println(card.face + " " + card.value);
            ImageIcon icon = new ImageIcon(getClass().getResource(fileLocation + card.imageName));
            setIcon(icon);
            
//            addMouseListener(new MouseAdapter()
//            {
//                @Override
//                public void mouseClicked(MouseEvent e)
//                {
//                    System.out.println("Click");
//                    if(e.getButton() == 2) {
//                        list.remove(list.getSelectedIndex());
//                    }
//                }
//
//                @Override
//                public void mouseEntered(MouseEvent e)
//                {
//                    System.out.println("Entered");
//                }
//                
//                
//                
//            });
            
            return this;
        }
        
    }
}
