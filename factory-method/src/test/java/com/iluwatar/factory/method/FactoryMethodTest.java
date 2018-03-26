/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.factory.method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The Factory Method is a creational design pattern which uses factory methods to deal with the
 * problem of creating objects without specifying the exact class of object that will be created.
 * This is done by creating objects via calling a factory method either specified in an interface
 * and implemented by child classes, or implemented in a base class and optionally overridden by
 * derived classes—rather than by calling a constructor.
 * 
 * <p>Factory produces the object of its liking. 
 * The weapon {@link Weapon} manufactured by the
 * blacksmith depends on the kind of factory implementation it is referring to.
 *
 *工厂方法创建型设计模式,使用工厂方法来处理
 *创建对象的问题没有指定具体类的对象将被创建。
 *这是通过创建对象通过调用工厂方法中指定一个接口
 *由子类实现,或在基类中实现,选择覆盖
 *派生的类,而不是通过调用构造函数。
 *
 * < p >工厂产生喜欢的对象。
 *武器} { @link武器的制造
 *铁匠取决于工厂实现它指的是。
 * </p>
 */
public class FactoryMethodTest {

  /**
   * Testing {@link OrcBlacksmith} to produce a SPEAR asserting that the Weapon is an instance 
   * of {@link OrcWeapon}.
   */
  @Test
  public void testOrcBlacksmithWithSpear() {
    Blacksmith blacksmith = new OrcBlacksmith();
    Weapon weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
    verifyWeapon(weapon, WeaponType.SPEAR, OrcWeapon.class);
  }

  /**
   * Testing {@link OrcBlacksmith} to produce an AXE asserting that the Weapon is an instance
   *  of {@link OrcWeapon}.
   */
  @Test
  public void testOrcBlacksmithWithAxe() {
    Blacksmith blacksmith = new OrcBlacksmith();
    Weapon weapon = blacksmith.manufactureWeapon(WeaponType.AXE);
    verifyWeapon(weapon, WeaponType.AXE, OrcWeapon.class);
  }

  /**
   * Testing {@link ElfBlacksmith} to produce a SHORT_SWORD asserting that the Weapon is an
   * instance of {@link ElfWeapon}.
   */
  @Test
  public void testElfBlacksmithWithShortSword() {
    Blacksmith blacksmith = new ElfBlacksmith();
    Weapon weapon = blacksmith.manufactureWeapon(WeaponType.SHORT_SWORD);
    verifyWeapon(weapon, WeaponType.SHORT_SWORD, ElfWeapon.class);
  }

  /**
   * Testing {@link ElfBlacksmith} to produce a SPEAR asserting that the Weapon is an instance
   * of {@link ElfWeapon}.
   */
  @Test
  public void testElfBlacksmithWithSpear() {
    Blacksmith blacksmith = new ElfBlacksmith();
    Weapon weapon = blacksmith.manufactureWeapon(WeaponType.SPEAR);
    verifyWeapon(weapon, WeaponType.SPEAR, ElfWeapon.class);
  }

  /**
   * This method asserts that the weapon object that is passed is an instance of the clazz and the
   * weapon is of type expectedWeaponType.
   * 
   * @param weapon weapon object which is to be verified
   * @param expectedWeaponType expected WeaponType of the weapon
   * @param clazz expected class of the weapon
   */
  private void verifyWeapon(Weapon weapon, WeaponType expectedWeaponType, Class<?> clazz) {
    assertTrue(clazz.isInstance(weapon), "Weapon must be an object of: " + clazz.getName());
    assertEquals(expectedWeaponType, weapon.getWeaponType(), "Weapon must be of weaponType: " + expectedWeaponType);
  }
}
