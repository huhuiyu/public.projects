function MD5Encoder() {}

MD5Encoder.rhex = function(num) {
  var hex_chr = '0123456789abcdef';
  str = '';
  for (j = 0; j <= 3; j++) {
    str += hex_chr.charAt((num >> (j * 8 + 4)) & 0x0f) + hex_chr.charAt((num >> (j * 8)) & 0x0f);
  }
  return str;
};

MD5Encoder.str2blks_MD5 = function(str) {
  nblk = ((str.length + 8) >> 6) + 1;
  blks = new Array(nblk * 16);
  for (i = 0; i < nblk * 16; i++) blks[i] = 0;
  for (i = 0; i < str.length; i++) {
    blks[i >> 2] |= str.charCodeAt(i) << ((i % 4) * 8);
  }
  blks[i >> 2] |= 0x80 << ((i % 4) * 8);
  blks[nblk * 16 - 2] = str.length * 8;
  return blks;
};

MD5Encoder.add = function(x, y) {
  var lsw = (x & 0xffff) + (y & 0xffff);
  var msw = (x >> 16) + (y >> 16) + (lsw >> 16);
  return (msw << 16) | (lsw & 0xffff);
};

MD5Encoder.rol = function(num, cnt) {
  return (num << cnt) | (num >>> (32 - cnt));
};

MD5Encoder.cmn = function(q, a, b, x, s, t) {
  return MD5Encoder.add(MD5Encoder.rol(MD5Encoder.add(MD5Encoder.add(a, q), MD5Encoder.add(x, t)), s), b);
};
MD5Encoder.ff = function(a, b, c, d, x, s, t) {
  return MD5Encoder.cmn((b & c) | (~b & d), a, b, x, s, t);
};
MD5Encoder.gg = function(a, b, c, d, x, s, t) {
  return MD5Encoder.cmn((b & d) | (c & ~d), a, b, x, s, t);
};
MD5Encoder.hh = function(a, b, c, d, x, s, t) {
  return MD5Encoder.cmn(b ^ c ^ d, a, b, x, s, t);
};
MD5Encoder.ii = function(a, b, c, d, x, s, t) {
  return MD5Encoder.cmn(c ^ (b | ~d), a, b, x, s, t);
};

/*
 * Take a string and return the hex representation of its MD5.
 */
MD5Encoder.calcMD5 = function(str) {
  x = MD5Encoder.str2blks_MD5(str);
  a = 1732584193;
  b = -271733879;
  c = -1732584194;
  d = 271733878;

  for (i = 0; i < x.length; i += 16) {
    olda = a;
    oldb = b;
    oldc = c;
    oldd = d;

    a = MD5Encoder.ff(a, b, c, d, x[i + 0], 7, -680876936);
    d = MD5Encoder.ff(d, a, b, c, x[i + 1], 12, -389564586);
    c = MD5Encoder.ff(c, d, a, b, x[i + 2], 17, 606105819);
    b = MD5Encoder.ff(b, c, d, a, x[i + 3], 22, -1044525330);
    a = MD5Encoder.ff(a, b, c, d, x[i + 4], 7, -176418897);
    d = MD5Encoder.ff(d, a, b, c, x[i + 5], 12, 1200080426);
    c = MD5Encoder.ff(c, d, a, b, x[i + 6], 17, -1473231341);
    b = MD5Encoder.ff(b, c, d, a, x[i + 7], 22, -45705983);
    a = MD5Encoder.ff(a, b, c, d, x[i + 8], 7, 1770035416);
    d = MD5Encoder.ff(d, a, b, c, x[i + 9], 12, -1958414417);
    c = MD5Encoder.ff(c, d, a, b, x[i + 10], 17, -42063);
    b = MD5Encoder.ff(b, c, d, a, x[i + 11], 22, -1990404162);
    a = MD5Encoder.ff(a, b, c, d, x[i + 12], 7, 1804603682);
    d = MD5Encoder.ff(d, a, b, c, x[i + 13], 12, -40341101);
    c = MD5Encoder.ff(c, d, a, b, x[i + 14], 17, -1502002290);
    b = MD5Encoder.ff(b, c, d, a, x[i + 15], 22, 1236535329);

    a = MD5Encoder.gg(a, b, c, d, x[i + 1], 5, -165796510);
    d = MD5Encoder.gg(d, a, b, c, x[i + 6], 9, -1069501632);
    c = MD5Encoder.gg(c, d, a, b, x[i + 11], 14, 643717713);
    b = MD5Encoder.gg(b, c, d, a, x[i + 0], 20, -373897302);
    a = MD5Encoder.gg(a, b, c, d, x[i + 5], 5, -701558691);
    d = MD5Encoder.gg(d, a, b, c, x[i + 10], 9, 38016083);
    c = MD5Encoder.gg(c, d, a, b, x[i + 15], 14, -660478335);
    b = MD5Encoder.gg(b, c, d, a, x[i + 4], 20, -405537848);
    a = MD5Encoder.gg(a, b, c, d, x[i + 9], 5, 568446438);
    d = MD5Encoder.gg(d, a, b, c, x[i + 14], 9, -1019803690);
    c = MD5Encoder.gg(c, d, a, b, x[i + 3], 14, -187363961);
    b = MD5Encoder.gg(b, c, d, a, x[i + 8], 20, 1163531501);
    a = MD5Encoder.gg(a, b, c, d, x[i + 13], 5, -1444681467);
    d = MD5Encoder.gg(d, a, b, c, x[i + 2], 9, -51403784);
    c = MD5Encoder.gg(c, d, a, b, x[i + 7], 14, 1735328473);
    b = MD5Encoder.gg(b, c, d, a, x[i + 12], 20, -1926607734);

    a = MD5Encoder.hh(a, b, c, d, x[i + 5], 4, -378558);
    d = MD5Encoder.hh(d, a, b, c, x[i + 8], 11, -2022574463);
    c = MD5Encoder.hh(c, d, a, b, x[i + 11], 16, 1839030562);
    b = MD5Encoder.hh(b, c, d, a, x[i + 14], 23, -35309556);
    a = MD5Encoder.hh(a, b, c, d, x[i + 1], 4, -1530992060);
    d = MD5Encoder.hh(d, a, b, c, x[i + 4], 11, 1272893353);
    c = MD5Encoder.hh(c, d, a, b, x[i + 7], 16, -155497632);
    b = MD5Encoder.hh(b, c, d, a, x[i + 10], 23, -1094730640);
    a = MD5Encoder.hh(a, b, c, d, x[i + 13], 4, 681279174);
    d = MD5Encoder.hh(d, a, b, c, x[i + 0], 11, -358537222);
    c = MD5Encoder.hh(c, d, a, b, x[i + 3], 16, -722521979);
    b = MD5Encoder.hh(b, c, d, a, x[i + 6], 23, 76029189);
    a = MD5Encoder.hh(a, b, c, d, x[i + 9], 4, -640364487);
    d = MD5Encoder.hh(d, a, b, c, x[i + 12], 11, -421815835);
    c = MD5Encoder.hh(c, d, a, b, x[i + 15], 16, 530742520);
    b = MD5Encoder.hh(b, c, d, a, x[i + 2], 23, -995338651);

    a = MD5Encoder.ii(a, b, c, d, x[i + 0], 6, -198630844);
    d = MD5Encoder.ii(d, a, b, c, x[i + 7], 10, 1126891415);
    c = MD5Encoder.ii(c, d, a, b, x[i + 14], 15, -1416354905);
    b = MD5Encoder.ii(b, c, d, a, x[i + 5], 21, -57434055);
    a = MD5Encoder.ii(a, b, c, d, x[i + 12], 6, 1700485571);
    d = MD5Encoder.ii(d, a, b, c, x[i + 3], 10, -1894986606);
    c = MD5Encoder.ii(c, d, a, b, x[i + 10], 15, -1051523);
    b = MD5Encoder.ii(b, c, d, a, x[i + 1], 21, -2054922799);
    a = MD5Encoder.ii(a, b, c, d, x[i + 8], 6, 1873313359);
    d = MD5Encoder.ii(d, a, b, c, x[i + 15], 10, -30611744);
    c = MD5Encoder.ii(c, d, a, b, x[i + 6], 15, -1560198380);
    b = MD5Encoder.ii(b, c, d, a, x[i + 13], 21, 1309151649);
    a = MD5Encoder.ii(a, b, c, d, x[i + 4], 6, -145523070);
    d = MD5Encoder.ii(d, a, b, c, x[i + 11], 10, -1120210379);
    c = MD5Encoder.ii(c, d, a, b, x[i + 2], 15, 718787259);
    b = MD5Encoder.ii(b, c, d, a, x[i + 9], 21, -343485551);

    a = MD5Encoder.add(a, olda);
    b = MD5Encoder.add(b, oldb);
    c = MD5Encoder.add(c, oldc);
    d = MD5Encoder.add(d, oldd);
  }
  return MD5Encoder.rhex(a) + MD5Encoder.rhex(b) + MD5Encoder.rhex(c) + MD5Encoder.rhex(d);
};
