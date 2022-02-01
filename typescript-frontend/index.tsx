interface Book{
  id : string
  title : string
  available : string
}
async function getBooks () : Promise<string> {
  return fetch('http://localhost:8080/books')
    .then((response) => response.json())
    .then((book) => {
      return book
    })
}

async function generateTable () {
  const data = await getBooks()
  const table = document.querySelector('#mainTable') as HTMLTableElement
  const books = Object.assign(new Array<Book>(), data)

  books.forEach((value: Book) => {
    const row = table.insertRow()

    const idCell = row.insertCell()
    idCell.innerText = value.id

    const titleCell = row.insertCell()
    titleCell.innerText = value.title

    const availableCell = row.insertCell()
    availableCell.innerText = value.available

  })
}

generateTable()
