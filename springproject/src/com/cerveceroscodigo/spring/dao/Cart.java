package com.cerveceroscodigo.spring.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;


public class Cart {
	
	private long cartId;
	private List<Item> cartItems; //tillater dobble entrys hvilket er nice
	private Customer owner;
	private String sillyName = "Kundevogn!"; //For testing
	
	/**
	 * Må nok beholde denne konstruktøren ettersom Spring aksesserer alle datafelt 
	 * direkte uten setters også når de er innkapsulert som private.
	 */
	public Cart(){
		this.cartId = Calendar.getInstance().getTimeInMillis();
		cartItems = new ArrayList<Item>();
//		cartItems.add(new Item()); //brukte denne til å legge inn en dummy vare
	}
	
	public Cart(Customer customer){
		this.owner = customer;
		this.cartId = Calendar.getInstance().getTimeInMillis();
		cartItems = new ArrayList<Item>();
	}
	
	public boolean addToCart(Item item){
		return cartItems.add(item);
	}
	
	public Item getNthCartItem(int n){
		return cartItems.get(n);
	}
	
	public Item removeNthCartItem(int n){
		return cartItems.remove(n);
	}
	
	public int getCartSize(){
		return cartItems.size();
	}
	
	public void removeAllCartItems(){
		cartItems.clear();
	}
	
	public long getCartId(){
		return cartId;
	}
	
	public String getSillyName() {
		return sillyName;
	}

	public void setSillyName(String sillyName) {
		this.sillyName = sillyName;
	}

	public Customer getCartOwner(){
		return owner;
	}
	
	public List<Item> getCartItems(){
		return cartItems;
	}
	
	@Override
	public String toString(){
		Iterator<Item> i = cartItems.iterator();
		StringBuilder b = new StringBuilder();
		while(i.hasNext()){
			b.append(i.next().toString());
			b.append("\n");
		}
		return b.toString();
	}
}
