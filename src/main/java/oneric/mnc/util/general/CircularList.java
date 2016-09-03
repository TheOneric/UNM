package oneric.mnc.util.general;

import java.util.LinkedList;

import java.util.Iterator;

public class CircularList<E> extends LinkedList<E> {
	
	public CircularList(E[] elements) {
		for(E e : elements)
			this.add(e);
	}
	
	@Override
	public E get(int index) {
		int i = index % this.size();
		return super.get(i < 0 ? (i + this.size()) : (i));
	}
	
	/**
	 * Removes all empty parts of the circular List, meaning every 'null' Object is omitted
	 * @return <code>true</code> if this list changed as a result of the call
	 * */
	public boolean removeEmptyParts() {
		Iterator<E> it = this.iterator();
		E next;
		boolean flag = false;
		while(it.hasNext()) {
			next = it.next();
			if(next == null) {
				flag = true;
				it.remove();
			}
		}
		return flag;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o != null && o instanceof CircularList ) 
		{
			CircularList list = (CircularList)o;
			if(this.isEmpty() && list.isEmpty()) {
				return true;
			}
			else if(compare(this, list)) {
				return true;
			} else {
				
				CircularList list1 = (CircularList) this.clone(); //Move to HellAltar ???  TODO
				list1.removeEmptyParts();
				CircularList list2 = (CircularList) list.clone();
				list2.removeEmptyParts();
				return compare(list1, list2);
			}
			
		}
		return false;
	}
	
	/**
	 * Private method used during the {@link #equals(Object) equals} method
	 * */
	private boolean compare(CircularList list1, CircularList list2) {
		if(list1.size() == list2.size())
		{
			Object first = list1.getFirst();
			if(list2.contains(first)) {
				
				int i1 = list2.indexOf(first);
				int ie = list2.lastIndexOf(first);
				//if(i1 != ie) {
					
					boolean stat = compareStraight(list1, list2, i1);
					while(!stat && i1 != ie)
					{
						Iterator it = list2.listIterator(i1 + 1);
						while(it.hasNext()) {
							i1++;
							if(it.next().equals(first)) {
								break;
							}
						}
						
						stat = compareStraight(list1, list2, i1);
					}
					
					return stat;
				/*}
				else {
					return compareStraight(list1, list2, i1);     REDUNDANT
				}*/
				
			} else{ 
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Private method used during the {@link #compare(CircularList) compare} method
	 * It can be safely assumed that both lists are non-empty and have the same number of elements 
	 * @param offset Offset of the second list to start with when checking
	 * */
	private boolean compareStraight(CircularList list1, CircularList list2, int offset) {
		for(int i = 1; i < list1.size(); i++) {
			if(!list1.get(i).equals(list2.get(offset + i)))
				return false;
		}
		return true;
	}

}
