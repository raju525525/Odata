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
package org.apache.olingo.client.core.data.v3;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.net.URI;

import org.apache.olingo.client.api.uri.SegmentType;
import org.apache.olingo.client.core.data.AbstractServiceDocument;
import org.apache.olingo.client.core.data.JSONServiceDocumentDeserializer;

/**
 * Service document, represented via JSON.
 */
@JsonDeserialize(using = JSONServiceDocumentDeserializer.class)
public class JSONServiceDocumentImpl extends AbstractServiceDocument {

  private static final long serialVersionUID = 4195734928526398830L;

  private String metadata;

  @Override
  public URI getBaseURI() {
    URI baseURI = null;
    if (metadata != null) {
      final String metadataURI = getMetadata();
      baseURI = URI.create(metadataURI.substring(0, metadataURI.indexOf(SegmentType.METADATA.getValue())));
    }

    return baseURI;
  }

  /**
   * Gets the metadata URI.
   *
   * @return the metadata URI
   */
  public String getMetadata() {
    return metadata;
  }

  /**
   * Sets the metadata URI.
   *
   * @param metadata metadata URI.
   */
  public void setMetadata(final String metadata) {
    this.metadata = metadata;
  }
}