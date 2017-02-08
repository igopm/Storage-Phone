package com.sp.jdbc.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.jdbc.dao.PhoneDAO;
import com.sp.jdbc.model.Phone;
import com.sp.jdbc.util.DateTimeHelper;


/**
 * @author Maschikevich Igor
 * @version 1.0
 */
public class PhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PAGE_EDIT = "/EditPhone.jsp";
	private static final String PAGE_LIST = "/ListPhone.jsp";

	private static final String ACTION_VALUE = "action";
	private static final String ACTION_DELETE = "delete";
	private static final String ACTION_EDIT = "edit";
	private static final String ACTION_LIST = "list";
	private static final String ATTRIBUTE_ITEM = "item";
	private static final String ATTRIBUTE_LIST = "list";

	private static final String PARAMETER_ENTITY_ID = "id";
	private static final String PARAMETER_ENTITY_BRAND = "brand";
	private static final String PARAMETER_ENTITY_MODEL = "model";
	private static final String PARAMETER_ENTITY_DATE = "date";

	private PhoneDAO dao;

	public PhoneController() {
		super();
		dao = PhoneDAO.getInstance();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter(ACTION_VALUE);

		if (action != null)
			switch (action) {
			case ACTION_DELETE:
				int itemId = Integer.parseInt(request
						.getParameter(PARAMETER_ENTITY_ID));
				dao.delete(itemId);
				forward = PAGE_LIST;
				request.setAttribute(ATTRIBUTE_LIST, dao.selectAll());
				break;

			case ACTION_EDIT:
				forward = PAGE_EDIT;
				int userId = Integer.parseInt(request
						.getParameter(PARAMETER_ENTITY_ID));
				Phone item = dao.select(userId);
				request.setAttribute(ATTRIBUTE_ITEM, item);
				break;

			case ACTION_LIST:
				forward = PAGE_LIST;
				request.setAttribute(ATTRIBUTE_LIST, dao.selectAll());
				break;

			default:
				forward = PAGE_EDIT;
				break;
			}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Phone item = parse(request);
		if (item.isNew()) {
			dao.insert(item);
		} else {
			dao.update(item);
		}
		RequestDispatcher view = request.getRequestDispatcher(PAGE_LIST);
		request.setAttribute(ATTRIBUTE_LIST, dao.selectAll());
		view.forward(request, response);
	}

	private Phone parse(HttpServletRequest request) {
		Phone item = new Phone();
		item.setBrand(request.getParameter(PARAMETER_ENTITY_BRAND));
		item.setModel(request.getParameter(PARAMETER_ENTITY_MODEL));

		Date date = DateTimeHelper.getSimpleDate(request
				.getParameter(PARAMETER_ENTITY_DATE));
		if (date != null)
			item.setDate(date);

		String userid = request.getParameter(PARAMETER_ENTITY_ID);
		if (userid != null && !userid.isEmpty()) {
			item.setId(Long.parseLong(userid));
		}
		return item;
	}
}
