/*
 * File: BigIntegerCalculator.java Date: Jul 16, 2017 Author: Sid Chopra Class: CS 112, Summer 2,
 * 2017 Purpose: This is a solution for HW 04, Problem B.1, a calculator for BigInts, based on
 * Dikjstra's two-stack algorithm.
 */

package hw4;

import java.io.*;
import java.util.*;

public class BigIntCalculator {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Input an Expression");

    while (sc.hasNext()) {
      String s = sc.nextLine();
      s = s.replaceAll("\\(", " \\( ");
      s = s.replaceAll("\\)", " \\) ");
      s = s.replaceAll("\\*", " \\* ");
      s = s.replaceAll("\\+", " \\+ ");
      s = s.trim();
      String[] exp = s.split("\\s+");

      if (exp[0].equals("-1")) {
        break;
      }

      StringStack Ops = new StringStack();
      BigIntStack Nums = new BigIntStack();
      for (int i = 0; i < exp.length; i++) {
        if (exp[i].equals("(")) {
          continue;
        } else if (exp[i].equals("+") || exp[i].equals("*")) {
          Ops.push(exp[i]);
        } else if (exp[i].equals(")")) {
          BigInt x = Nums.pop();
          BigInt y = Nums.pop();
          String z = Ops.pop();
          if (z.equals("+")) {
            BigInt a = x.add(y);
            Nums.push(a);

          } else if (z.equals("*")) {
            BigInt m = x.mult(y);
            Nums.push(m);
          }
        } else { // must be a number
          BigInt g = new BigInt(exp[i]);
          Nums.push(g);
        }

      }

      BigInt r = Nums.pop();
      System.out.println("Result is " + r);


    }

    System.out.println("bye!");
    sc.close();
  }
}
