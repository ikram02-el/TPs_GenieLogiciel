function addition(a, b) {
  return a + b;
}

if (require.main === module) {
  console.log("Résultat:", addition(5, 3));
}

module.exports = { addition };
