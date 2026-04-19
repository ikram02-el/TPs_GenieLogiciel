// addition(a, b) -> retourne la somme de a et b
function addition(a, b) {
  return a + b; // simple addition
}
if (require.main === module) {
  console.log("Résultat:", addition(5, 3));
}
module.exports = { addition };
