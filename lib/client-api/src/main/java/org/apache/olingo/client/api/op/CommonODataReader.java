/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.olingo.client.api.op;

import java.io.InputStream;
import java.io.Serializable;
import org.apache.olingo.client.api.data.ODataError;
import org.apache.olingo.commons.api.domain.ODataEntity;
import org.apache.olingo.commons.api.domain.ODataEntitySet;
import org.apache.olingo.commons.api.domain.ODataProperty;
import org.apache.olingo.commons.api.domain.ODataServiceDocument;
import org.apache.olingo.commons.api.format.ODataFormat;
import org.apache.olingo.commons.api.format.ODataPubFormat;
import org.apache.olingo.commons.api.edm.Edm;

/**
 * OData reader.
 * <br/>
 * Use this class to de-serialize an OData response body.
 * <br/>
 * This class provides method helpers to de-serialize an entire feed, a set of entities and a single entity as well.
 */
public interface CommonODataReader extends Serializable {

  /**
   * Parses a stream into metadata representation.
   *
   * @param input stream to de-serialize.
   * @return metadata representation.
   */
  Edm readMetadata(InputStream input);

  /**
   * Parses an OData service document.
   *
   * @param input stream to de-serialize.
   * @param format de-serialize as XML or JSON
   * @return List of URIs.
   */
  ODataServiceDocument readServiceDocument(InputStream input, ODataFormat format);

  /**
   * De-Serializes a stream into an OData entity set.
   *
   * @param input stream to de-serialize.
   * @param format de-serialize as AtomFeed or JSONFeed
   * @return de-serialized entity set.
   */
  ODataEntitySet readEntitySet(InputStream input, ODataPubFormat format);

  /**
   * Parses a stream taking care to de-serializes the first OData entity found.
   *
   * @param input stream to de-serialize.
   * @param format de-serialize as AtomEntry or JSONEntry
   * @return entity de-serialized.
   */
  ODataEntity readEntity(InputStream input, ODataPubFormat format);

  /**
   * Parses a stream taking care to de-serialize the first OData entity property found.
   *
   * @param input stream to de-serialize.
   * @param format de-serialize as XML or JSON
   * @return OData entity property de-serialized.
   */
  ODataProperty readProperty(InputStream input, ODataFormat format);

  /**
   * Parses a stream into an OData error.
   *
   * @param inputStream stream to de-serialize.
   * @param isXML 'TRUE' if the error is in XML format.
   * @return OData error.
   */
  ODataError readError(InputStream inputStream, boolean isXML);

  /**
   * Parses a stream into the object type specified by the given reference.
   *
   * @param <T> expected object type.
   * @param src input stream.
   * @param format format
   * @param reference reference.
   * @return read object.
   */
  <T> T read(InputStream src, String format, Class<T> reference);
}
