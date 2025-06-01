package com.mycar.nhom13.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Car_Images")
public class CarImage {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	public int imageId;

	@Column(name = "image")
	public String image;

	@ManyToOne
	@JoinColumn(name = "car_id")
	@JsonBackReference(value = "image")
	@JsonIgnore
	public Car car;

	public CarImage() {

	}

	public CarImage(int imageId, String image, Car car) {
		super();
		this.imageId = imageId;
		this.image = image;
		this.car = car;
	}

	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
