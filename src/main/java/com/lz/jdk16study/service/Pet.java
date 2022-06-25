package com.lz.jdk16study.service;

/**
 *Sealed 类封闭 | since jdk15
 * 可扩展性不是面向对象编程的一个重要指标吗？为什么要限制可扩展性呢？
 * 其实，面向对象编程的最佳实践之一，就是要把可扩展性的限制在可以预测和控制的范围内，
 * 而不是无限的可扩展性。
 *
 * 通过 sealed 定义接口或者抽象类
 */
public sealed  interface Pet permits Cat {
}
