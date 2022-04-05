/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.shopping;

import java.util.HashMap;
import java.util.Map;
import sample.user.ProductDTO;

/**
 *
 * @author Admin
 */
public class Cart {
    private Map<String, Book> cart;

    public Cart(Map<String, Book> cart) {
        this.cart = cart;
    }

    public Cart() {
    }

    public Map<String, Book> getCart() {
        return cart;
    }

    public void setCart(Map<String, Book> cart) {
        this.cart = cart;
    }
    public void add(Book book,ProductDTO DTO)
    {   
        
        if(this.cart==null)
        {
            this.cart=new HashMap<>();
            
        }
        if(this.cart.containsKey(DTO.getProductID()))
        {
            int currentQuantity=this.cart.get(DTO.getProductID()).getQuantityCART();
            if(currentQuantity<DTO.getQuantity() && (currentQuantity+book.getQuantityCART())<=DTO.getQuantity())
            {
                this.cart.get(DTO.getProductID()).setQuantityCART(currentQuantity+book.getQuantityCART());
            }
        
    }
        cart.put(book.getProductID(), book);
    }
    
    public void delete(String  id)
    {
        if(this.cart==null)
        {
            return ;
        }
        if(this.cart.containsKey(id))
        {
            this.cart.remove(id);
        }
        
    }
    public void update(Book book)    
    {
        if(this.cart==null) return;
        if(this.cart.containsKey(book.getProductID()))
        {
            this.cart.replace(book.getProductID(), book);
        }
    }
}
