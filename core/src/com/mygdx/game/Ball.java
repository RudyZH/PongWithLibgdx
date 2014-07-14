package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class Ball extends Rectangle {
    Texture ballImage;
    float xVel;
    float yVel;
    String name;

    public Ball() {
        this.name = "ball";
        Pixmap ballPixmap = new Pixmap(10, 10, Pixmap.Format.RGBA8888);
        ballPixmap.setColor(Color.PINK);
        ballPixmap.fill();
        ballImage = new Texture(ballPixmap);
        resetPosition();
        this.width = ballImage.getWidth();
        this.height = ballImage.getHeight();
        this.xVel = -200f;
        this.yVel = -200f;

    }

    public void resetVelocityX(int direction) {
        this.xVel = 200f * direction;
    }

    public float getCombinedVelocity(float delta) {
        double velSquared = Math.pow(xVel, 2) + Math.pow(yVel, 2);
        return (float) Math.sqrt(velSquared) * delta;
    }

    public void moveX(float deltaTime) {
        this.x += this.xVel * deltaTime;
    }

    public void moveY(float deltaTime) {
        this.y -= this.yVel * deltaTime;
    }

    public void dispose() {
        ballImage.dispose();
    }

    public float getTop() {
        return this.y + this.height;
    }

    public void setTop(float posY) {
        this.y = posY - this.height;
    }

    public void setBottom(float posY) {
        this.y = posY;
    }

    public float getRight() {
        return this.x + this.width;
    }

    public void resetPosition() {
        this.x = PongForAndroid.WIDTH / 2;
        this.y = PongForAndroid.HEIGHT / 2;
    }

    public void reverseDirectionX() {
        this.xVel *= -1;
    }

    public void reverseDirectionY() {
        this.yVel *= -1;
    }
}