package project_2;
import java.util.*;

public interface orderedList<P extends Comparable<P>> {
	boolean add(P element, int index);
	P set(int index, P element);
	P get(int index);
	int indexOf(P element);
	P remove(int index);
	public int size();
	boolean remove(P element);
}

public class Poly <P extends Comparable<P>> implements
orderedList<P>
{
Comparator<P> compare;

private head;
private tail;

public static class Node<P>
{
	private P element;
	private Node<P> next;
}

public class ListIterator implements Iterator<P>
{
	private Node<P> current;

	@Override
	public boolean hasNext()
	{
		if (current == null)
			return head != null;
		else
			return current.next != null;
	}

	@Override
	public P next()
	{
		if (current == null)
			current = head;
		else
			current = current.next;
		return current.element;
	}

	@Override
	public void remove()
	{
	}
}

private Node<P> head, tail;
private int size = 0;

public Poly()
{
	compare = (P left, P right) -> left.compareTo(right);
}

public Poly(Comparator<P> compare)
{
	this.compare = compare;
}

public boolean add(P element)
{
	head = add(head, element);
	size++;
	return true;
}

private Node<P> add(Node<P> node, P element)
{
	if (node == null || compare.compare(element, node.element) < 0)
	{
		Node<P> newNode = new Node();
		newNode.element = element;
		newNode.next = node;
		return newNode;
	}
	else
	{
		node.next = add(node.next, element);
		return node;
	}
}

@Override
public boolean add(P element, int index)
{
	throw new UnsupportedOperationException("Not permitted");
}

@Override
public boolean remove(P element)
{
	size--;
	return (head = remove(head, element)) != null;
}

private Node<P> remove(Node<P> node, P element)
{
	if (node == null || compare.compare(element, node.element) < 0)
		return null;
	else if (compare.compare(element, node.element) == 0)
		return node.next;
	else
	{
		node.next = remove(node.next, element);
		return node;
	}
}

@Override
public P remove(int index)
{
	if (index >= size || head == null)
		return null;
	P element;
	if (index == 0)
	{	
		element = head.element;
		head = head.next;
	}
	else
	{
		Node<P> node = remove(head, 0, index);
		element = node.next.element;
		node.next = node.next.next;
	}
	size--;
	return element;
}

private Node<P> remove(Node<P> node, int current, int index)
{
	if (current == index - 1)
		return node;
	else
		return remove(node.next, current + 1, index);
}

@Override
public P set(int index, P element)
{
	throw new UnsupportedOperationException("Not permitted");
}

@Override
public P get(int index)
{
	return get(head, 0, index);
}

private P get(Node<P> node, int current, int index)
{
	if (node == null)
		return null;
	if (index == current)
		return node.element;
	return get(node.next, current + 1, index);
}

@Override
public int indexOf(P element)
{
	return indexOf(head, 0, element);
}

public boolean contains(P element)
{
	return indexOf(head, 0, element) != -1;
}

private int indexOf(Node<P> node, int index, P element)
{
	if (node == null || compare.compare(element, node.element) < 0)
		return -1;
	if (compare.compare(element, node.element) == 0)
		return index;
	return indexOf(node.next, index + 1, element);
}

public Iterator<P> iterator()
{
	return new ListIterator();
}

@Override
public int size()
{
	return size;
}
}


