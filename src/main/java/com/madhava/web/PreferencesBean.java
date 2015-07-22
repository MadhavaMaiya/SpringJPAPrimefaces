/*
 * Created on Jul 22, 2015
 * @author Madhava
 */
package com.madhava.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Component;

import com.madhava.domain.common.Preferences;
import com.madhava.service.security.IUser;

/**
 * Class PreferencesBean
 * 
 * @author Madhava
 * @since Jul 22, 2015 - 11:24:55 AM
 * @version UserManagement 1.0
 */
@Component
@SessionScoped
public class PreferencesBean {

	private transient IUser user;

	private Preferences prefernces;

	@Resource(name = "sessionMap")
	private Map<String, Object> sessionMap;

}
