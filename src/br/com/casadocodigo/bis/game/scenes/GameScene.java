package br.com.casadocodigo.bis.game.scenes;

import java.util.ArrayList;
import java.util.List;

import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.types.CGPoint;

import static br.com.casadocodigo.bis.config.DeviceSettings.screenHeight;
import static br.com.casadocodigo.bis.config.DeviceSettings.screenWidth;
import static br.com.casadocodigo.bis.config.DeviceSettings.screenResolution;

import br.com.casadocodigo.bis.config.Assets;
import br.com.casadocodigo.bis.game.engines.MeteorsEngine;
import br.com.casadocodigo.bis.game.interfaces.MeteorsEngineDelegate;
import br.com.casadocodigo.bis.game.objects.Meteor;
import br.com.casadocodigo.bis.screens.ScreenBackground;

public class GameScene extends CCLayer implements MeteorsEngineDelegate {
	
	// Layers
	private CCLayer meteorsLayer;
	
	// Engines
	private MeteorsEngine meteorsEngine;
	
	// Arrays
	@SuppressWarnings("rawtypes")
	private ArrayList meteorsArray;
	
	// Screens
	
	// Game Objects
	private ScreenBackground background;
	
	
	private GameScene() {
		this.background = new ScreenBackground(Assets.BACKGROUND);
		this.background.setPosition(
			screenResolution(
				CGPoint.ccp(
					screenWidth() / 2.0f,
					screenHeight() / 2.0f)));
		this.addChild(this.background);
	}
	
	public static CCScene createGame() {
		CCScene scene = CCScene.node();
		GameScene layer = new GameScene();
		scene.addChild(layer);
		return scene;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void createMeteor(Meteor meteor) {
		this.meteorsLayer.addChild(meteor);
		meteor.start();
		this.meteorsArray.add(meteor);
	}
	/* não funciona por falta de parametros
	@Override
	public void createMeteor(Meteor, float x, float y, float vel, double ang, int vl) {
		this.meteorsLayer.addChild(meteor);
		meteor.start();
		this.meteorsArray.add(meteor);
	}
	*/
}
