package com.sp.jdbc.junit;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.sp.jdbc.dao.PhoneDAO;
import com.sp.jdbc.model.Phone;

public class PhoneDAOTest {
	@Test
	public void testDao() {
		PhoneDAO.getInstance().deleteAll();
		assertEquals(0, PhoneDAO.getInstance().selectAll().size());

		Phone b = new Phone("Nokia", "N95", new Date());
		PhoneDAO.getInstance().insert(b);

		List<Phone> phones = PhoneDAO.getInstance().selectAll();
		assertEquals(1, phones.size());
		assertEquals(b.getBrand(), phones.get(0).getBrand());
		assertEquals(b.getModel(), phones.get(0).getModel());
		assertEquals(b.getDate(), phones.get(0).getDate());
		PhoneDAO.getInstance().delete(phones.get(0));
		assertEquals(0, PhoneDAO.getInstance().selectAll().size());

		PhoneDAO.getInstance().insert(b);
		PhoneDAO.getInstance().deleteAll();
		assertEquals(0, PhoneDAO.getInstance().selectAll().size());
	}
}
