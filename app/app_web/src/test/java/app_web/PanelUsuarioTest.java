package app_web;

import static org.junit.Assert.*;

import org.dgac.app.web.bean.PanelUsuarioMB;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.Module.SetupContext;

public class PanelUsuarioTest {
	
	private PanelUsuarioMB pumb;
	
	@Before
	public void setUp(){
		PanelUsuarioMB pumb = new PanelUsuarioMB();
	}

	@Test
	public void getCurrentMonthTest() {
		PanelUsuarioMB pumb = new PanelUsuarioMB();
		int mesActual = 7;
		assertEquals(mesActual, pumb.getCurrentMonth(),0);
		
	}
	
	@Test
	public void getCurrentYearTest() {
		PanelUsuarioMB pumb = new PanelUsuarioMB();
		int anno = 2016;
		assertEquals(anno, pumb.getCurrentYear(),0);
		
	}

}
