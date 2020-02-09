/**
 * Copyright (c) 2010-2020 Mark Allen, Norbert Bartels.
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
package com.restfb;

import java.util.stream.Stream;

public enum Version {

  /**
   * unversiond api
   */
  UNVERSIONED(null),

  /**
   * <tt>Graph API 2.12</tt>, available until May 1, 2020
   *
   * @since January 30, 2018
   */
  VERSION_2_12("v2.12"),

  /**
   * <tt>Graph API 3.0</tt>, available until July 26, 2020
   *
   * @since May 1, 2018
   */
  VERSION_3_0("v3.0"),

  /**
   * <tt>Graph API 3.1</tt>, available until October 23, 2020
   *
   * @since July 26, 2018
   */
  VERSION_3_1("v3.1"),

  /**
   * <tt>Graph API 3.2</tt>, available until April 30, 2021
   *
   * @since October 23, 2018
   */
  VERSION_3_2("v3.2"),

  /**
   * <tt>Graph API 3.3</tt>, available until July 29, 2021
   *
   * @since April 30, 2019
   */
  VERSION_3_3("v3.3"),

  /**
   * <tt>Graph API 4.0</tt>, available until October 29, 2021
   *
   * @since July 29, 2019
   */
  VERSION_4_0("v4.0"),

  /**
   * <tt>Graph API 5.0</tt>, available until February 3rd, 2022
   *
   * @since October 29, 2019
   */
  VERSION_5_0("v5.0"),

  /**
   * <tt>Graph API 6.0</tt>, available at least until February, 2022
   *
   * @since February 3rd, 2020
   */
  VERSION_6_0("v6.0"),

  /**
   * convenience enum to provide simple access to the latest supported Graph API Version.
   * <p>
   * the current version is <tt>Graph API 6.0</tt>
   * </p>
   */
  LATEST("v6.0");

  private final String urlElement;

  Version(String urlElement) {
    this.urlElement = urlElement;
  }

  public String getUrlElement() {
    return this.urlElement;
  }

  public boolean isUrlElementRequired() {
    return null != this.urlElement;
  }

  /**
   * converts a String (for example the url parameter) into a Version object
   * 
   * @param urlElementStr
   *          String that should
   * @return the generated version
   */
  public static Version getVersionFromString(String urlElementStr) {
    if (urlElementStr != null) {
      return Stream.of(Version.values()).filter(v -> urlElementStr.equals(v.getUrlElement())).findFirst()
              .orElse(UNVERSIONED);
    }

    return UNVERSIONED;
  }
}
