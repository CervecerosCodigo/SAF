package com.cerveceroscodigo.spring.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Cart {

	private long cartId;
	private List<Item> cartItems; // tillater dobble entrys hvilket er nice
	private Customer owner;
	private String sillyName = "Kundevogn!"; // For testing
	private double totalPrice;

	/**
	 * Må nok beholde denne konstruktøren ettersom Spring aksesserer alle
	 * datafelt direkte uten setters også når de er innkapsulert som private.
	 */
	public Cart() {
		this.cartId = Calendar.getInstance().getTimeInMillis();
		cartItems = new ArrayList<Item>();
		totalPrice = 0;
		// cartItems.add(new Item()); //brukte denne til å legge inn en dummy
		// vare
	}

	public Cart(Customer customer) {
		this.owner = customer;
		this.cartId = Calendar.getInstance().getTimeInMillis();
		cartItems = new ArrayList<Item>();
		totalPrice = 0;
	}

	public boolean addToCart(Item item) {
		totalPrice += item.getPriceIn(); //oppdaterer totalt pris
		return cartItems.add(item);
	}

	public Item getNthCartItem(int n) {
		return cartItems.get(n);
	}

	public Item removeNthCartItem(int n) {
		return cartItems.remove(n);
	}

	public int getCartSize() {
		return cartItems.size();
	}

	public void removeAllCartItems() {
		cartItems.clear();
	}

	public long getCartId() {
		return cartId;
	}

	public String getSillyName() {
		return sillyName;
	}

	public void setSillyName(String sillyName) {
		this.sillyName = sillyName;
	}

	public Customer getCartOwner() {
		return owner;
	}

	public List<Item> getCartItems() {
		return cartItems;
	}
	
	public double getTotalPrice(){
		return totalPrice;
	}

	/**
	 * Returns total price for all items in basket by recalculating
	 * the price of all items in the list.
	 * @return
	 */
	public double calculateTotalPrice() {
		double totalPrice2 = 0;
		
		if (cartItems != null) {
			Iterator<Item> i = cartItems.iterator();

			while (i.hasNext()) {
				totalPrice2 += i.next().getPriceIn();
			}
		}
		return totalPrice2;
	}

	@Override
	public String toString() {
		Iterator<Item> i = cartItems.iterator();
		StringBuilder b = new StringBuilder();
		while (i.hasNext()) {
			b.append(i.next().toString());
			b.append("\n");
		}
		return b.toString();
	}
}
