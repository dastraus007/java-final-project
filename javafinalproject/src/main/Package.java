package main;

import java.awt.Color;

public class Package extends Exception{
	
	int _choose;
	String _nameFile;
	int [] _data ;
	Color _color;
	
	
	public Package(int choose, String nameFile, int[] data , Color color) {
		super();
		this._choose = choose;
		this._nameFile = nameFile + "";
		this._data = new int[data.length];
		for (int i : data) {
			this._data[i] = data[i];
		}
		this._color = color;
	}
	
	public Package(Package a) {
		this._choose = a.getChoose();
		this._nameFile = a.getNameFile() + "";
		this._data = new int[a.getData().length];
		for (int i : a.getData()) {
			this._data[i] = a.getData()[i];
		}
		this._color = a.get_color();
		
	}

	public Color get_color() {
		return _color;
	}


	public void set_color(Color _color) {
		this._color = _color;
	}


	public Package() {
		super();
	}


	public int getChoose() {
		return _choose;
	}
	public void setChoose(int choose) {
		this._choose = choose;
	}
	public String getNameFile() {
		return _nameFile;
	}
	public void setNameFile(String nameFile) {
		this._nameFile = nameFile;
	}
	public int[] getData() {
		return _data;
	}
	public void setData(int[] data) {
		this._data = data;
	}
	
	
}
