package com.patholab.service;

import com.patholab.entity.Address;

public interface AddressService {
	Address saveAddress(Address address);
	Address findAddress(int id);
}
