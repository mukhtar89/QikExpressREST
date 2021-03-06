/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-10-17 16:43:55 UTC)
 * on 2016-11-07 at 22:41:52 UTC 
 * Modify at your own risk.
 */

package com.appspot.qikexpress.groceryoperations.model;

/**
 * Model definition for Grocery.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the groceryoperations. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Grocery extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer brandId;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String photoReference;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer photoWidth;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String placeId;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String profileImage;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getBrandId() {
    return brandId;
  }

  /**
   * @param brandId brandId or {@code null} for none
   */
  public Grocery setBrandId(java.lang.Integer brandId) {
    this.brandId = brandId;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPhotoReference() {
    return photoReference;
  }

  /**
   * @param photoReference photoReference or {@code null} for none
   */
  public Grocery setPhotoReference(java.lang.String photoReference) {
    this.photoReference = photoReference;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getPhotoWidth() {
    return photoWidth;
  }

  /**
   * @param photoWidth photoWidth or {@code null} for none
   */
  public Grocery setPhotoWidth(java.lang.Integer photoWidth) {
    this.photoWidth = photoWidth;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPlaceId() {
    return placeId;
  }

  /**
   * @param placeId placeId or {@code null} for none
   */
  public Grocery setPlaceId(java.lang.String placeId) {
    this.placeId = placeId;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getProfileImage() {
    return profileImage;
  }

  /**
   * @param profileImage profileImage or {@code null} for none
   */
  public Grocery setProfileImage(java.lang.String profileImage) {
    this.profileImage = profileImage;
    return this;
  }

  @Override
  public Grocery set(String fieldName, Object value) {
    return (Grocery) super.set(fieldName, value);
  }

  @Override
  public Grocery clone() {
    return (Grocery) super.clone();
  }

}
