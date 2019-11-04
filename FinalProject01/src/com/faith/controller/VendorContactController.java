package com.faith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.faith.dao.IVendorContactDao;
import com.faith.bean.VendorContact;

@CrossOrigin

@RestController
@RequestMapping("/api")
public class VendorContactController {
	
	    @Autowired
	    IVendorContactDao vdao;
	    
	    //insert  vendor details
		@RequestMapping(value = "/insertvendordetails", method = 
				RequestMethod.POST)
		public void insertVendorContactDetails(@RequestBody VendorContact vendorContact)
		{
				vdao.insertVendorContactDetails(vendorContact);
		}
		
		//update vendor details
		@RequestMapping(value = "/updatevendordetails/{vId}", method = RequestMethod.PUT)
		public void updateVendorDetails(@RequestBody VendorContact vendorContact)
		{
		
				vdao.updateVendorDetails(vendorContact);
		}
		
		
		//disable vendor 
		@RequestMapping(value = "/disablevendor/{vId}", method = RequestMethod.PUT)
		void disableVendor(@PathVariable("vId") int vId) {
			vdao.disableVendor(vId);
		}
		
		//search vendor details
		
		@RequestMapping(value = "/vendordetails", method = RequestMethod.GET)

		public List getVendorDetails()
		{
			List list;
			System.out.println("Getting All Vendor details");
			list = vdao. getAllDetails();
			return list;
		}
		
		//get by id
		@RequestMapping(value = "/vendorbyid/{vId}", method = RequestMethod.GET)
		public VendorContact getVendorById(@PathVariable("vId") int vId) 
		{
			VendorContact vendorContact =vdao.getVendorById(vId);
			return vendorContact;
		}
		
		//get by Name
		@RequestMapping(value="/search/{searchString}",method=RequestMethod.GET)
		public List  searchVendorDetails(@PathVariable("searchString") String searchString)
		{
			System.out.println("Get Vendor details by name");
			List list;
			System.out.println(searchString);
			list=vdao.searchVendorDetails(searchString);
			return list;
		}

	    
	    

}
