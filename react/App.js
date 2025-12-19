const reactHeader = React.createElement("h1", {id: "heading", channel: "IndexChannel"}, 'Hello World from React');
const rootReact = ReactDOM.createRoot(document.getElementById("root"));
rootReact.render(reactHeader);

