/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
// File generated by hadoop record compiler. Do not edit.
package fm.last.darling.io.records;

public class NSpacePoint extends org.apache.hadoop.record.Record {
  private static final org.apache.hadoop.record.meta.RecordTypeInfo _rio_recTypeInfo;
  private static org.apache.hadoop.record.meta.RecordTypeInfo _rio_rtiFilter;
  private static int[] _rio_rtiFilterFields;
  static {
    _rio_recTypeInfo = new org.apache.hadoop.record.meta.RecordTypeInfo("NSpacePoint");
    _rio_recTypeInfo.addField("timestamp", org.apache.hadoop.record.meta.TypeID.LongTypeID);
    _rio_recTypeInfo.addField("dimensions", new org.apache.hadoop.record.meta.MapTypeID(
        org.apache.hadoop.record.meta.TypeID.StringTypeID, org.apache.hadoop.record.meta.TypeID.StringTypeID));
    _rio_recTypeInfo.addField("unit", org.apache.hadoop.record.meta.TypeID.StringTypeID);
  }

  private long timestamp;
  private java.util.TreeMap<String, String> dimensions;
  private String unit;

  public NSpacePoint() {
  }

  public NSpacePoint(final long timestamp, final java.util.TreeMap<String, String> dimensions, final String unit) {
    this.timestamp = timestamp;
    this.dimensions = dimensions;
    this.unit = unit;
  }

  public static org.apache.hadoop.record.meta.RecordTypeInfo getTypeInfo() {
    return _rio_recTypeInfo;
  }

  public static void setTypeFilter(org.apache.hadoop.record.meta.RecordTypeInfo rti) {
    if (null == rti)
      return;
    _rio_rtiFilter = rti;
    _rio_rtiFilterFields = null;
  }

  private static void setupRtiFields() {
    if (null == _rio_rtiFilter)
      return;
    // we may already have done this
    if (null != _rio_rtiFilterFields)
      return;
    int _rio_i, _rio_j;
    _rio_rtiFilterFields = new int[_rio_rtiFilter.getFieldTypeInfos().size()];
    for (_rio_i = 0; _rio_i < _rio_rtiFilterFields.length; _rio_i++) {
      _rio_rtiFilterFields[_rio_i] = 0;
    }
    java.util.Iterator<org.apache.hadoop.record.meta.FieldTypeInfo> _rio_itFilter = _rio_rtiFilter.getFieldTypeInfos()
        .iterator();
    _rio_i = 0;
    while (_rio_itFilter.hasNext()) {
      org.apache.hadoop.record.meta.FieldTypeInfo _rio_tInfoFilter = _rio_itFilter.next();
      java.util.Iterator<org.apache.hadoop.record.meta.FieldTypeInfo> _rio_it = _rio_recTypeInfo.getFieldTypeInfos()
          .iterator();
      _rio_j = 1;
      while (_rio_it.hasNext()) {
        org.apache.hadoop.record.meta.FieldTypeInfo _rio_tInfo = _rio_it.next();
        if (_rio_tInfo.equals(_rio_tInfoFilter)) {
          _rio_rtiFilterFields[_rio_i] = _rio_j;
          break;
        }
        _rio_j++;
      }
      _rio_i++;
    }
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(final long timestamp) {
    this.timestamp = timestamp;
  }

  public java.util.TreeMap<String, String> getDimensions() {
    return dimensions;
  }

  public void setDimensions(final java.util.TreeMap<String, String> dimensions) {
    this.dimensions = dimensions;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(final String unit) {
    this.unit = unit;
  }

  public void serialize(final org.apache.hadoop.record.RecordOutput _rio_a, final String _rio_tag)
    throws java.io.IOException {
    _rio_a.startRecord(this, _rio_tag);
    _rio_a.writeLong(timestamp, "timestamp");
    {
      _rio_a.startMap(dimensions, "dimensions");
      java.util.Set<java.util.Map.Entry<String, String>> _rio_es1 = dimensions.entrySet();
      for (java.util.Iterator<java.util.Map.Entry<String, String>> _rio_midx1 = _rio_es1.iterator(); _rio_midx1
          .hasNext();) {
        java.util.Map.Entry<String, String> _rio_me1 = _rio_midx1.next();
        String _rio_k1 = _rio_me1.getKey();
        String _rio_v1 = _rio_me1.getValue();
        _rio_a.writeString(_rio_k1, "_rio_k1");
        _rio_a.writeString(_rio_v1, "_rio_v1");
      }
      _rio_a.endMap(dimensions, "dimensions");
    }
    _rio_a.writeString(unit, "unit");
    _rio_a.endRecord(this, _rio_tag);
  }

  private void deserializeWithoutFilter(final org.apache.hadoop.record.RecordInput _rio_a, final String _rio_tag)
    throws java.io.IOException {
    _rio_a.startRecord(_rio_tag);
    timestamp = _rio_a.readLong("timestamp");
    {
      org.apache.hadoop.record.Index _rio_midx1 = _rio_a.startMap("dimensions");
      dimensions = new java.util.TreeMap<String, String>();
      for (; !_rio_midx1.done(); _rio_midx1.incr()) {
        String _rio_k1;
        _rio_k1 = _rio_a.readString("_rio_k1");
        String _rio_v1;
        _rio_v1 = _rio_a.readString("_rio_v1");
        dimensions.put(_rio_k1, _rio_v1);
      }
      _rio_a.endMap("dimensions");
    }
    unit = _rio_a.readString("unit");
    _rio_a.endRecord(_rio_tag);
  }

  public void deserialize(final org.apache.hadoop.record.RecordInput _rio_a, final String _rio_tag)
    throws java.io.IOException {
    if (null == _rio_rtiFilter) {
      deserializeWithoutFilter(_rio_a, _rio_tag);
      return;
    }
    // if we're here, we need to read based on version info
    _rio_a.startRecord(_rio_tag);
    setupRtiFields();
    for (int _rio_i = 0; _rio_i < _rio_rtiFilter.getFieldTypeInfos().size(); _rio_i++) {
      if (1 == _rio_rtiFilterFields[_rio_i]) {
        timestamp = _rio_a.readLong("timestamp");
      } else if (2 == _rio_rtiFilterFields[_rio_i]) {
        {
          org.apache.hadoop.record.Index _rio_midx1 = _rio_a.startMap("dimensions");
          dimensions = new java.util.TreeMap<String, String>();
          for (; !_rio_midx1.done(); _rio_midx1.incr()) {
            String _rio_k1;
            _rio_k1 = _rio_a.readString("_rio_k1");
            String _rio_v1;
            _rio_v1 = _rio_a.readString("_rio_v1");
            dimensions.put(_rio_k1, _rio_v1);
          }
          _rio_a.endMap("dimensions");
        }
      } else if (3 == _rio_rtiFilterFields[_rio_i]) {
        unit = _rio_a.readString("unit");
      } else {
        java.util.ArrayList<org.apache.hadoop.record.meta.FieldTypeInfo> typeInfos = (java.util.ArrayList<org.apache.hadoop.record.meta.FieldTypeInfo>) (_rio_rtiFilter
            .getFieldTypeInfos());
        org.apache.hadoop.record.meta.Utils.skip(_rio_a, typeInfos.get(_rio_i).getFieldID(), typeInfos.get(_rio_i)
            .getTypeID());
      }
    }
    _rio_a.endRecord(_rio_tag);
  }

  public int compareTo(final Object _rio_peer_) throws ClassCastException {
    if (!(_rio_peer_ instanceof NSpacePoint)) {
      throw new ClassCastException("Comparing different types of records.");
    }
    NSpacePoint _rio_peer = (NSpacePoint) _rio_peer_;
    int _rio_ret = 0;
    _rio_ret = (timestamp == _rio_peer.timestamp) ? 0 : ((timestamp < _rio_peer.timestamp) ? -1 : 1);
    if (_rio_ret != 0)
      return _rio_ret;
    {
      java.util.Set<String> _rio_set10 = dimensions.keySet();
      java.util.Set<String> _rio_set20 = _rio_peer.dimensions.keySet();
      java.util.Iterator<String> _rio_miter10 = _rio_set10.iterator();
      java.util.Iterator<String> _rio_miter20 = _rio_set20.iterator();
      for (; _rio_miter10.hasNext() && _rio_miter20.hasNext();) {
        String _rio_k10 = _rio_miter10.next();
        String _rio_k20 = _rio_miter20.next();
        _rio_ret = _rio_k10.compareTo(_rio_k20);
        if (_rio_ret != 0) {
          return _rio_ret;
        }
      }
      _rio_ret = (_rio_set10.size() - _rio_set20.size());
    }
    if (_rio_ret != 0)
      return _rio_ret;
    _rio_ret = unit.compareTo(_rio_peer.unit);
    if (_rio_ret != 0)
      return _rio_ret;
    return _rio_ret;
  }

  public boolean equals(final Object _rio_peer_) {
    if (!(_rio_peer_ instanceof NSpacePoint)) {
      return false;
    }
    if (_rio_peer_ == this) {
      return true;
    }
    NSpacePoint _rio_peer = (NSpacePoint) _rio_peer_;
    boolean _rio_ret = false;
    _rio_ret = (timestamp == _rio_peer.timestamp);
    if (!_rio_ret)
      return _rio_ret;
    _rio_ret = dimensions.equals(_rio_peer.dimensions);
    if (!_rio_ret)
      return _rio_ret;
    _rio_ret = unit.equals(_rio_peer.unit);
    if (!_rio_ret)
      return _rio_ret;
    return _rio_ret;
  }

  public Object clone() throws CloneNotSupportedException {
    NSpacePoint _rio_other = new NSpacePoint();
    _rio_other.timestamp = this.timestamp;
    _rio_other.dimensions = (java.util.TreeMap<String, String>) this.dimensions.clone();
    _rio_other.unit = this.unit;
    return _rio_other;
  }

  public int hashCode() {
    int _rio_result = 17;
    int _rio_ret;
    _rio_ret = (int) (timestamp ^ (timestamp >>> 32));
    _rio_result = 37 * _rio_result + _rio_ret;
    _rio_ret = dimensions.hashCode();
    _rio_result = 37 * _rio_result + _rio_ret;
    _rio_ret = unit.hashCode();
    _rio_result = 37 * _rio_result + _rio_ret;
    return _rio_result;
  }

  public static String signature() {
    return "LNSpacePoint(l{ss}s)";
  }

  public static class Comparator extends org.apache.hadoop.record.RecordComparator {
    public Comparator() {
      super(NSpacePoint.class);
    }

    static public int slurpRaw(byte[] b, int s, int l) {
      try {
        int os = s;
        {
          long i = org.apache.hadoop.record.Utils.readVLong(b, s);
          int z = org.apache.hadoop.record.Utils.getVIntSize(i);
          s += z;
          l -= z;
        }
        {
          int mi1 = org.apache.hadoop.record.Utils.readVInt(b, s);
          int mz1 = org.apache.hadoop.record.Utils.getVIntSize(mi1);
          s += mz1;
          l -= mz1;
          for (int midx1 = 0; midx1 < mi1; midx1++) {
            {
              int i = org.apache.hadoop.record.Utils.readVInt(b, s);
              int z = org.apache.hadoop.record.Utils.getVIntSize(i);
              s += (z + i);
              l -= (z + i);
            }
            {
              int i = org.apache.hadoop.record.Utils.readVInt(b, s);
              int z = org.apache.hadoop.record.Utils.getVIntSize(i);
              s += (z + i);
              l -= (z + i);
            }
          }
        }
        {
          int i = org.apache.hadoop.record.Utils.readVInt(b, s);
          int z = org.apache.hadoop.record.Utils.getVIntSize(i);
          s += (z + i);
          l -= (z + i);
        }
        return (os - s);
      } catch (java.io.IOException e) {
        throw new RuntimeException(e);
      }
    }

    static public int compareRaw(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
      try {
        int os1 = s1;
        {
          long i1 = org.apache.hadoop.record.Utils.readVLong(b1, s1);
          long i2 = org.apache.hadoop.record.Utils.readVLong(b2, s2);
          if (i1 != i2) {
            return ((i1 - i2) < 0) ? -1 : 0;
          }
          int z1 = org.apache.hadoop.record.Utils.getVIntSize(i1);
          int z2 = org.apache.hadoop.record.Utils.getVIntSize(i2);
          s1 += z1;
          s2 += z2;
          l1 -= z1;
          l2 -= z2;
        }
        {
          int mi11 = org.apache.hadoop.record.Utils.readVInt(b1, s1);
          int mi21 = org.apache.hadoop.record.Utils.readVInt(b2, s2);
          int mz11 = org.apache.hadoop.record.Utils.getVIntSize(mi11);
          int mz21 = org.apache.hadoop.record.Utils.getVIntSize(mi21);
          s1 += mz11;
          s2 += mz21;
          l1 -= mz11;
          l2 -= mz21;
          for (int midx1 = 0; midx1 < mi11 && midx1 < mi21; midx1++) {
            {
              int i1 = org.apache.hadoop.record.Utils.readVInt(b1, s1);
              int i2 = org.apache.hadoop.record.Utils.readVInt(b2, s2);
              int z1 = org.apache.hadoop.record.Utils.getVIntSize(i1);
              int z2 = org.apache.hadoop.record.Utils.getVIntSize(i2);
              s1 += z1;
              s2 += z2;
              l1 -= z1;
              l2 -= z2;
              int r1 = org.apache.hadoop.record.Utils.compareBytes(b1, s1, i1, b2, s2, i2);
              if (r1 != 0) {
                return (r1 < 0) ? -1 : 0;
              }
              s1 += i1;
              s2 += i2;
              l1 -= i1;
              l1 -= i2;
            }
            {
              int i = org.apache.hadoop.record.Utils.readVInt(b1, s1);
              int z = org.apache.hadoop.record.Utils.getVIntSize(i);
              s1 += (z + i);
              l1 -= (z + i);
            }
            {
              int i = org.apache.hadoop.record.Utils.readVInt(b2, s2);
              int z = org.apache.hadoop.record.Utils.getVIntSize(i);
              s2 += (z + i);
              l2 -= (z + i);
            }
          }
          if (mi11 != mi21) {
            return (mi11 < mi21) ? -1 : 0;
          }
        }
        {
          int i1 = org.apache.hadoop.record.Utils.readVInt(b1, s1);
          int i2 = org.apache.hadoop.record.Utils.readVInt(b2, s2);
          int z1 = org.apache.hadoop.record.Utils.getVIntSize(i1);
          int z2 = org.apache.hadoop.record.Utils.getVIntSize(i2);
          s1 += z1;
          s2 += z2;
          l1 -= z1;
          l2 -= z2;
          int r1 = org.apache.hadoop.record.Utils.compareBytes(b1, s1, i1, b2, s2, i2);
          if (r1 != 0) {
            return (r1 < 0) ? -1 : 0;
          }
          s1 += i1;
          s2 += i2;
          l1 -= i1;
          l1 -= i2;
        }
        return (os1 - s1);
      } catch (java.io.IOException e) {
        throw new RuntimeException(e);
      }
    }

    public int compare(byte[] b1, int s1, int l1, byte[] b2, int s2, int l2) {
      int ret = compareRaw(b1, s1, l1, b2, s2, l2);
      return (ret == -1) ? -1 : ((ret == 0) ? 1 : 0);
    }
  }

  static {
    org.apache.hadoop.record.RecordComparator.define(NSpacePoint.class, new Comparator());
  }
}
